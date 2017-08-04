class Codec:
    letters = "abcdefghijklmnopqrstuvwxyz0123456789"
    hashmap = {}
    def generateShort(self):
        s = ""
        for i in range(6):
            index = random.randint(0, len(self.letters) - 1)
            s += self.letters[index]
        
        return s
        
    def encode(self, longUrl):
        """Encodes a URL to a shortened URL.
        
        :type longUrl: str
        :rtype: str
        """
        shortUrl = self.generateShort()
        while shortUrl in self.hashmap:
            shortUrl = self.generateShort()
        part = longUrl[:longUrl.find("/", 2) + 1]
        self.hashmap[part + shortUrl] = longUrl
        return part + shortUrl

    def decode(self, shortUrl):
        """Decodes a shortened URL to its original URL.
        
        :type shortUrl: str
        :rtype: str
        """
        return self.hashmap[shortUrl]

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(url))