# encoding:utf-8
from pacong import html_downloader, html_outputer, html_parser, url_manager


class SpiderMain(object):
    def __init__(self):
        self.urls = url_manager.UrlManager()
        self.downloader = html_downloader.HtmlDownloader()
        self.parser = html_parser.HtmlParser()
        self.outputer = html_outputer.HtmlOutputer()

    def craw(self, root_url):
        count = 1
        self.urls.add_new_url(root_url)
        # 待爬取的url
        while self.urls.has_new_url():
            try:
                # 获取一个待爬取的url
                new_url = self.urls.get_new_url()
               # print('craw %d : %s' % (count, new_url))
                # 启动下载器
                html_cont = self.downloader.download(new_url)
                # 解析器，解析页面数据包
                new_urls, new_data = self.parser.paser(new_url, html_cont)  # 得到新的列表，以及新的数据
                # 添加进rul管理器
                self.urls.add_new_urls(new_urls)
                # 搜集数据
                self.outputer.collect_data(new_data)
                if count == 1000:
                    break
                count = count + 1
            except:
                counts =0
                print("爬取失败")
            # 输出搜集好的数据
        self.outputer.output_html()
        ss = self.urls.getUtls()
        print(ss)


if __name__ == "__main__":
    root_utl = "https://baike.baidu.com/item/Python/407313"
    java ="https://baike.baidu.com/item/java/85979"
    obj_spider = SpiderMain()
    obj_spider.craw(root_utl)

