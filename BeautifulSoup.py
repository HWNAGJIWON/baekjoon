import requests
import sys
from bs4 import BeautifulSoup
sys.stdout = open('output.txt','w')


## HTTP GET Request
req = requests.get('https://www.acmicpc.net/status?problem_id=&user_id=dnjs1318&language_id=-1&result_id=4')
## HTML 소스 가져오기
html = req.text
## BeautifulSoup으로 html소스를 python객체로 변환하기
## 첫 인자는 html소스코드, 두 번째 인자는 어떤 parser를 이용할지 명시.
## 이 글에서는 Python 내장 html.parser를 이용했다.
soup = BeautifulSoup(html, 'html.parser')


my_titles = soup.select(
    'td > a'
)
 ## my_titles는 list 객체
for title in my_titles:
     ##Tag안의 텍스트
     print(title.text)
     ##Tag의 속성을 가져오기 (ex: href속성)
     print(title.get('fromnow'))
