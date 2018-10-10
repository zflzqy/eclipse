class UrlManager(object):
    def __init__(self):
        self.new_urls = set()
        self.old_urls = set()

    def getUtls(self):
        return self.new_urls
    # 向管理器中添加一个新的url
    def add_new_url(self, url):
        if url is None:
            return
        if url not in self.new_urls and url not in self.old_urls:
            self.new_urls.add(url)

    # 批量添加
    def add_new_urls(self, url):
        if url is None or len(url) == 0:
            return
        for urls in url:
            self.add_new_url(urls)

    # 判断管理器中是否有新待爬取的rul
    def has_new_url(self):
        return len(self.new_urls) != 0

    # 获取一个新的待爬取url
    def get_new_url(self):
        new_url = self.new_urls.pop()
        self.old_urls.add(new_url)
        return new_url
