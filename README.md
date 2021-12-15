# url_shortening
사전 과제 URL_Shortening

## 목표
URL을 입력받아 짧게 줄여주고, Shortening된 URL을 입력하면 원래 URL로 리다이렉트하는 URL Shortening Service
예) https://en.wikipedia.org/wiki/URL_shortening => http://localhost/JZfOQNro

> URL 입력폼 제공 및 결과 출력
> 
> URL Shortening Key는 8 Character 이내로 생성되어야 합니다.
> 
> 동일한 URL에 대한 요청은 동일한 Shortening Key로 응답해야 합니다.
> 
> 동일한 URL에 대한 요청 수 정보를 가져야 한다(화면 제공 필수 아님)
> 
> Shortening된 URL을 요청받으면 원래 URL로 리다이렉트 합니다.
> 
> Database 사용은 필수 아님
 

다음의 경우 가산점이 부과됩니다.

> Unit test 및 Integration test 작성.


## 설치 및 빌드
Java install
> yum install java-11-openjdk.devel.x86_64
> 
> java -version


Repository Clone
> $ mkdir ~/web

> $ cd /web

> $ git clone https://github.com/wjdtnwhd777/url_shortening.git

Build
> $ ./gradlew bootJar

Execute
> $ java -jar ./build/libs/shortening_1.0.jar
