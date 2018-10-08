import scrapy


class QuotesSpider(scrapy.Spider):
    name = "ebay"

    def __init__(self, category=None, *args, **kwargs):
        super(QuotesSpider, self).__init__(*args, **kwargs)
        self.start_urls = ['https://www.ebay.in/sch/i.html?_from=R40&_trksid=p2050601.m570.l1313.TR0.TRC0.H0.X{}.TRS0&_nkw={}&_sacat=0'.format(category,category)]
        #self.domain = domain

    # url = 'https://www.amazon.in/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords={}', category
    # url = str(url)
    # # self.domain = domaincategory
    # start_urls = [url]
    def parse(self, response):
        for result in response.css('li.sresult.lvresult.clearfix.li'):
            title = result.css('h3.lvtitle a::text').extract_first()
            if title is not None: title=title.encode('utf-8')

            price =  result.css('li.lvprice.prc span.bold::text')[1].extract()
            if price is not None: price=price.encode('utf-8')

            buyurl = result.css('h3.lvtitle a::attr(href)').extract_first()
            if buyurl is not None: buyurl = buyurl.encode('utf-8')

            yield {
                'Title': title,
                'Price': price,
                'BuyUrl': buyurl
                #'author': str(quote.css('small.author::text').extract_first()),
                #'tags': str(quote.css('div.tags a.tag::text').extract()),
            }
