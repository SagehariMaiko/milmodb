from scraper.spiders.KaigoKensakuSpider import KaigoKensakuSpider


class SubSpider(KaigoKensakuSpider):
	name = "SubSpider"
	def __init__(self):
		self.serviceType="110"
		super(SubSpider,self).__init__()
	pass