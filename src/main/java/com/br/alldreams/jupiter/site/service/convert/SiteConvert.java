/**
 *
 */
package com.br.alldreams.jupiter.site.service.convert;

import org.mapstruct.Mapper;

import com.br.alldreams.jupiter.base.domain.ConvertPadrao;
import com.br.alldreams.jupiter.site.dto.SiteDTO;
import com.br.alldreams.jupiter.site.repository.domain.Site;

/**
 * @author Jorge Demetrio
 * @since 16 de jan de 2020 01:25:31
 * @version 1.0
 */
@Mapper(componentModel = "spring", implementationName = "SiteConvertImpl", implementationPackage = "<PACKAGE_NAME>.impl", imports = {
		Site.class })
public interface SiteConvert extends ConvertPadrao<SiteDTO, Site> {

//	SiteDTO toSite(Site site);
//
//	@InheritInverseConfiguration
//	Site toSite(SiteDTO site);
//
//	@Mapping(target = "id", ignore = true)
//	@Mapping(target = "criador", ignore = true)
//	@Mapping(target = "dataCriacao", ignore = true)
//	@Mapping(target = "ipCriador", ignore = true)
//	Site toSite(SiteDTO site, @MappingTarget Site origem);
//
//	List<Site> toSites(List<SiteDTO> site);
//
//	List<SiteDTO> toSitesDTO(List<Site> site);

}
