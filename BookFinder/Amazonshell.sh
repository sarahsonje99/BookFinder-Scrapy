#!/bin/bash
cd ./crawler
scrapy crawl amazon -o opAmazon.csv -a category=$1
