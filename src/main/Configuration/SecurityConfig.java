import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2ErrorCodes;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;
import java.util.List;
import java.util.Objects;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  
  @Value("${auth0.audience}")
  private String audience;

  @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
  private String issuer;
  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests()

      .mvcMatchers(HttpMethod.GET, "/api/demandes/**").permitAll() // GET requests don't need auth

      .anyRequest()

      .authenticated()

      .and()

      .oauth2ResourceServer()

      .jwt()

      .decoder(jwtDecoder());
  }

JwtDecoder jwtDecoder() {

    OAuth2TokenValidator<Jwt> withAudience = new AudienceValidator(audience);

    OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer(issuer);

    OAuth2TokenValidator<Jwt> validator = new DelegatingOAuth2TokenValidator<>(withAudience, withIssuer);

    NimbusJwtDecoder jwtDecoder = (NimbusJwtDecoder) JwtDecoders.fromOidcIssuerLocation(issuer);

    jwtDecoder.setJwtValidator(validator);
    
    return jwtDecoder;
  }
}