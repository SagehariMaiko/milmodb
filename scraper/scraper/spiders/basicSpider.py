# -*- coding: utf-8 -*-
import scrapy
from scrapy.http import Request
from scrapy.item import DictItem, Field
from scrapy.utils.project import get_project_settings
from  scrapy.contrib.loader import ItemLoader
from scraper.util import *
from scraper.items import GenericItem
from scrapy.contrib.spiders import CrawlSpider
from bs4 import BeautifulSoup
import re



class BasicSpider(CrawlSpider):
    settings = get_project_settings()
    name = "basicSpider"
    allowed_domains = ["kaigokensaku.jp"]
    def __init__(self,serviceType=None):
        self.start_urls = getStartUrls(int(serviceType))
        self.columns= readCSVFile(serviceType)

    def parse(self, response):   
        tree = BeautifulSoup(response.body)
        item = GenericItem()

        regex = re.compile(r"""action_kouhyou_detail_([0-9]+)_([0-9]+)_kani=true\&JigyosyoCd=([0-9\-]+)\&PrefCd=([0-9]+)\&VersionCd=([0-9]+)""")
        [details] = regex.findall(response.url)
        (year,versionCd1,jigyosyoCd,pref,versionCd2) = details

        item["service_type"] = tree.find_all(abbr = u"介護サービスの種類")[0].findNextSibling().text

        ## 経度・緯度はjavascriptから
        item["latitude"] = re.search("LatVal\s*\=\s*\'([0-9]+\.[0-9]+)\'",response.body).group(1)
        item["longitude"] = re.search("LonVal\s*\=\s*\'([0-9]+\.[0-9]+)\'",response.body).group(1)

        url = "http://www.kaigokensaku.jp/40/index.php?action_kouhyou_detail_"+year+"_"+versionCd1+"_kihon=true&JigyosyoCd="+jigyosyoCd+"&PrefCd="+pref+"&YNendo="+year+"&VersionCd="+versionCd2
        request = Request(url, callback=self.parseShousai)
        request.meta['item'] = item

        yield request

    def parseShousai(self,response):
        item = response.meta['item']
        tree = BeautifulSoup(response.body)

        for column in self.columns:
            (div_id,abbr,th_abbr,td,columnName) = column
            value = getDataValue(tree,div_id,abbr,th_abbr,td)
            item[columnName] = value
        yield item