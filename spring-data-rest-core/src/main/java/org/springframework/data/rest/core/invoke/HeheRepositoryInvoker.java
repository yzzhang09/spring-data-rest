/**
 * 
 */
package org.springframework.data.rest.core.invoke;

import java.io.Serializable;

import org.cl.hehe.support.repository.HeheRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.core.RepositoryInformation;

/**
 * @author zhangyi
 *
 */
public class HeheRepositoryInvoker extends PagingAndSortingRepositoryInvoker {

    private final HeheRepository<Object, Serializable> repository;

    /**
     * @param repository
     * @param information
     * @param conversionService
     */
    public HeheRepositoryInvoker(HeheRepository<Object, Serializable> repository, RepositoryInformation information,
                                 ConversionService conversionService) {
        super(repository, information, conversionService);
        this.repository = repository;
    }

    /* (non-Javadoc)
     * @see org.springframework.data.rest.core.invoke.HeheRepositoryInvoker#invokeFindAll(org.springframework.data.jpa.domain.Specification, org.springframework.data.domain.Pageable)
     */
    @Override
    public Iterable<Object> invokeFindAll(Specification<Object> spec, Pageable pageable) {
        return repository.findAll(spec, pageable);
    }

    /* (non-Javadoc)
     * @see org.springframework.data.rest.core.invoke.ReflectionRepositoryInvoker#invokeFindAll(org.springframework.data.jpa.domain.Specification, org.springframework.data.domain.Sort)
     */
    @Override
    public Iterable<Object> invokeFindAll(Specification<Object> spec, Sort sort) {
        return repository.findAll(spec, sort);
    }
}
