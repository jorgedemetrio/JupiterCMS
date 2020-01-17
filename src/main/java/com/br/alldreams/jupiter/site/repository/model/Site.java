/**
 *
 */
package com.br.alldreams.jupiter.site.repository.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.base.domain.ControleInformacaoAlteravel;
import com.br.alldreams.jupiter.base.domain.StatusEnum;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @since 14 de jan de 2020 22:50:54
 * @version 1.0
 */
@Data
@Validated
@Entity
@Table(name = "tb_site")
public class Site extends ControleInformacaoAlteravel implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -3769857701895659927L;

	@NotEmpty
	@Column(name = "name", insertable = true, updatable = true, nullable = false, length = 200)
	private String nome;

	@NotEmpty
	@Column(name = "dns", insertable = true, updatable = true, nullable = false, unique = true, length = 250)
	private String dns;

    @Column(name = "google_analytics", insertable = true, updatable = true, nullable = true, length = 200)
    private String googleAnalytics;

    @Column(name = "google_api_authenticator_key", insertable = true, updatable = true, nullable = true, length = 200)
    private String googleApiAuthenticatorKey;

    @Column(name = "google_api_authenticator_secret", insertable = true, updatable = true, nullable = true, length = 200)
    private String googleApiAuthenticatorSecret;

    @Column(name = "google_api_recaptcha_key", insertable = true, updatable = true, nullable = true, length = 200)
    private String googleApiRecaptchaKey;

    @Column(name = "google_api_recaptcha_secret", insertable = true, updatable = true, nullable = true, length = 200)
    private String googleApiRecaptchaSecret;

    @Column(name = "facebookPixel", insertable = true, updatable = true, nullable = true, length = 200)
    private String facebookPixel;

    @Column(name = "facebookApiKey", insertable = true, updatable = true, nullable = true, length = 200)
    private String facebookApiKey;

    @Column(name = "headers", insertable = true, updatable = true, nullable = true, length = 2000)
    private String headers;

    @Column(name = "footers", insertable = true, updatable = true, nullable = true, length = 2000)
    private String rodape;

    @Column(name = "colmuns", insertable = true, updatable = true, nullable = true, length = 2000)
    private Short colunas;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", insertable = true, updatable = true, nullable = true, length = 20)
    private TipoCMSEnum tipo;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", insertable = true, updatable = true, nullable = true, length = 20)
	private StatusEnum status;


}
