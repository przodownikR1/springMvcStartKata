package pl.java.borowiec.service.exception;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pl.java.borowiec.exception.UnExpectedException;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 11-04-2013 00:09:09
 */
public interface LoggerExceptionService {

	List<UnExpectedException> getAllUnexpectedException();

	UnExpectedException saveUnexpectedException(UnExpectedException unExpectedException);

	Page<UnExpectedException> findByException(String exception, Pageable pageable);

	Page<UnExpectedException> findByFunctionName(String functionName, Pageable pageable);

	Page<UnExpectedException> getPageUnExpectedExcetpion(Pageable pageable);

	void persistException(UnExpectedException uee);

	void removeAll();

	void removeBy(String exception);

}