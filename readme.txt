https://www.programmergate.com/spring-boot-spring-security-oauth2/


resource for oAuth.





Original application.properties



<!-- Change default server port and configure view resolver -->
server.port=9090
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
server.error.whitelabel.enabled=false

<!-- OAuth2 configuration -->
security.oauth2.client.clientId=900014336858-6gnulmg4td59gotv7382hr0a027l5i1b.apps.googleusercontent.com
security.oauth2.client.clientSecret=e67K2-xILBNWl5oPEPpP4f7z
security.oauth2.client.preEstablishedRedirectUri=http://localhost:9090/callback
security.oauth2.client.accessTokenUri=https://www.googleapis.com/oauth2/v3/token
security.oauth2.client.userAuthorizationUri=https://accounts.google.com/o/oauth2/auth
security.oauth2.client.tokenName=oauth_token
security.oauth2.client.authenticationScheme=query
security.oauth2.client.clientAuthenticationScheme=form
security.oauth2.client.scope=profile
security.oauth2.resource.user-info-uri=https://www.googleapis.com/userinfo/v2/me
security.oauth2.client.useCurrentUri=false



<!-- LOCAL ISAM -->



<!-- OAuth2 configuration -->
security.oauth2.client.clientId=testsclient
security.oauth2.client.clientSecret=D4DK1orfbUHydwGiByIV
security.oauth2.client.preEstablishedRedirectUri=http://localhost:9091/callback
security.oauth2.client.accessTokenUri=https://localhost:443/mga/sps/oauth/oauth20/token
security.oauth2.client.userAuthorizationUri=https://localhost/mga/sps/oauth/oauth20/authorize
security.oauth2.client.tokenName=oauth_token
security.oauth2.client.authenticationScheme=query
security.oauth2.client.clientAuthenticationScheme=form
security.oauth2.client.scope=profile email
security.oauth2.resource.user-info-uri=https://www.googleapis.com/userinfo/v2/me
security.oauth2.client.useCurrentUri=false

