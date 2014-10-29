# -*- coding: utf-8 -*-
## Helpful functions to aid crawling

import requests
import re
import scrapy
from scrapy.item import DictItem, Field
import codecs


def getTextById(tree,id):
    idString = "diff-c" + str(id)
    field = tree.find(diffid=idString)
    if field:
        return field.text 

def getAttributeValueById(tree,id,attribute):
    idString = "diff-c" + str(id)
    field = tree.find(diffid=idString)
    if field:
      value = field.get(attribute)
      if value:
        return value
      else:
        for i in field.descendants:
          if "get" in dir(i):
            return i.get(attribute)
    return u'データーなし'


def readCSVFile(serviceType):
  f = codecs.open(".\\scraper\\tableDefinitions\\"+serviceType+".csv",'r','utf-8' )
  results = []
  for line in f:
    csvArray = line.split(",")
    if csvArray[0] == "jigyosho jigyoshoShosai shosai" and not csvArray[4] =='-':
      div_id=csvArray[1]
      abbr= csvArray[3]
      th_abbr= csvArray[4]
      td = csvArray[5]
      columnName = csvArray[6]
      results.append((div_id,abbr,th_abbr,td,columnName))
  return results 



def getDataValue(tree,div_id,abbr,th_abbr,td):
  print "######" + abbr
  items = tree.find('div',id=div_id).select(u"[abbr^="+abbr+"]")
  if len(items)==1: ##Found a unique match
    item = items[0]
    if not th_abbr=="":
        return item.findNext(abbr=th_abbr).findNextSibling().text
    elif td[0].isdigit():
      for a in range(int(td[0])):
        item = item.findNextSibling()
      if "alt" in td:
        return item.img.get("alt") ## １番目のalt
      else:
        return item.text  ## １番目の

    else:##次のtrの１番目
      item = item.parent
      for a in range(int(td[5])):
        item = item.findNextSibling()
      return item.text
  else:
    return u"データーなし"

def create_item_class(class_name, field_list):
    field_dict = {}
    for field_name in field_list:
        field_dict[field_name] = Field()
    print field_dict

    return type(class_name, (DictItem,), field_dict)


def getColumnNamesFromCSV(path):
  result = []
  f = file(path)
  for line in f:
    csvArray = line.split(",")
    if(csvArray[0].isdigit()):
      result.append(csvArray[1])
  f.close()
  return result


def getStartUrls(facilityType):
    results =[]

    cityCds = [401374,401366,401331,401358,401323,401315,401340]
    for cityCd in cityCds:
        n=0
        while True:
            payload = {"PrefCd" : "40",
               "ServiceCd" : str(facilityType),
               "JShikuchosonCd" : str(cityCd),
               "method" : "result",
               "action_kouhyou_pref_search_list_list" : "true",
               "p_offset" : str(n*5),
               "p_count" : "5",      ## Changing p_count appears not to work
               "p_order_name" : "0",
               "p_sort_name" : "36"}
            n = n+1

            ## Search results for Fukuoka Prefecture
            page = requests.post("http://www.kaigokensaku.jp/40/index.php?action_kouhyou_pref_search_list_list=true&PrefCd=40",
                          data=payload)

            regex = re.compile(r"""\'url\'\:\'index.php\?action_kouhyou_detail_([0-9]+)_([0-9]+)_kani=true\&amp\;JigyosyoCd=(.*?)\&amp\;PrefCd=40&amp\;VersionCd=([0-9]+)""")

            if not regex.findall(page.text): ## End of search results
                break

            for regexMatch in regex.findall(page.text):
                (year,versionCd1,jigyosyoCd,versionCd2) = regexMatch
                url = "http://www.kaigokensaku.jp/40/index.php?action_kouhyou_detail_"+year+"_"+versionCd1+"_kani=true&JigyosyoCd="+jigyosyoCd+"&PrefCd=40&VersionCd="+versionCd2
                results.append(url)

    return tuple(set(results)) ## convert to set to remove duplicates