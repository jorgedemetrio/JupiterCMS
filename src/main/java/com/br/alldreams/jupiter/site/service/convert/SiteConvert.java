/**
 *
 */
package com.br.alldreams.jupiter.site.service.convert;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.br.alldreams.jupiter.site.dto.SiteDTO;
import com.br.alldreams.jupiter.site.repository.model.Site;

/**
 * @author Jorge Demetrio
 * @since 16 de jan de 2020 01:25:31
 * @version 1.0
 */
@Mapper(componentModel = "spring", implementationName = "SiteConvertImpl", implementationPackage = "<PACKAGE_NAME>.impl", imports = {
		Site.class })
public interface SiteConvert {

	SiteDTO toSite(Site site);

	@InheritInverseConfiguration
	Site toSite(SiteDTO site);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "criador", ignore = true)
	@Mapping(target = "dataCriacao", ignore = true)
	@Mapping(target = "ipCriador", ignore = true)
	Site toSite(SiteDTO site, @MappingTarget Site origem);

	List<Site> toSites(List<SiteDTO> site);

	List<SiteDTO> toSitesDTO(List<Site> site);

}
