package com.ing.model.mapper;

import com.ing.model.domain.BaseEntity;
import com.ing.model.dto.Dto;

public interface DtoEntityMapper<D extends Dto<?>, E extends BaseEntity<?>> {
	D mapToDto(E entity);
	E mapToEntity(D dto);
}
