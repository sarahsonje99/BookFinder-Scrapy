#!/bin/bash
cd ./crawler
scrapy crawl ebay -o opEbay.csv -a category=$1
