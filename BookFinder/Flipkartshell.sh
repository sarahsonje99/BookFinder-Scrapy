#!/bin/bash
cd ./crawler
scrapy crawl flipkart -o opFlipkart.csv -a category=$1
