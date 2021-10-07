from urllib.parse import urlencode

from requests import Request, Session
s = Session()
parameters = {'key': 'test',
              'value': '32',
              'mock': True,
              'sync': False}
base_url = "http://localhost:8080/demo2-1.0-SNAPSHOT/"+urlencode(parameters)

request = Request('GET', base_url)
prepped = request.prepare()
response = s.send(prepped)
print(response.content)
