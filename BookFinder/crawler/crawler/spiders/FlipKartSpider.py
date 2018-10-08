import scrapy


class QuotesSpider(scrapy.Spider):
    name = "flipkart"

    def __init__(self, category=None, *args, **kwargs):
        super(QuotesSpider, self).__init__(*args, **kwargs)
        self.start_urls = ['https://www.flipkart.com/search?q={}&otracker=start&as-show=off&as=off'.format(category)]
        #self.domain = domain

    # url = 'https://www.amazon.in/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords={}', category
    # url = str(url)
    # # self.domain = domaincategory
    # start_urls = [url]
    def parse(self, response):
        for result in response.css('div._3liAhj'):
            title = result.css('a._2cLu-l::text').extract_first()
            if title is not None: title=title.encode('utf-8')

            price = result.css('div._1uv9Cb div._1vC4OE::text')[1].extract().encode('utf-8')
            if price is not None: price=price.encode('utf-8')

            buyurl = 'https://www.flipkart.com'+result.css('a._2cLu-l::attr(href)').extract_first()
            if buyurl is not None: buyurl = buyurl.encode('utf-8')

            yield {
                'Title': title,
                'Price': price,
                'BuyUrl': buyurl
                #'author': str(quote.css('small.author::text').extract_first()),
                #'tags': str(quote.css('div.tags a.tag::text').extract()),
            }
