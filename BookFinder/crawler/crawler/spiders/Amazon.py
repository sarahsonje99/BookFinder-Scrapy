import scrapy


class QuotesSpider(scrapy.Spider):
    name = "amazon"

    def __init__(self, category=None, *args, **kwargs):
        super(QuotesSpider, self).__init__(*args, **kwargs)
        self.start_urls = ['https://www.amazon.in/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords={}'.format(category)]
        #self.domain = domain

   
    def parse(self, response):
        for result in response.css('li.s-result-item'):
            title = result.css('a.a-link-normal h2::text').extract_first()
            if title is not None: title=title.encode('utf-8')

            price = result.css('span.a-size-base.a-color-price.s-price.a-text-bold::text').extract_first()
            if price is not None: price=price.encode('utf-8')

            buyurl = result.css('a.a-link-normal.s-access-detail-page::attr(href)').extract_first()
            if buyurl is not None: buyurl = buyurl.encode('utf-8')

            yield {
                'Title': title,
                'Price': price,
                'BuyUrl': buyurl
                }
