
package pl.java.borowiec.service.exception.impl;

import java.util.List;

import org.apache.commons.lang.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pl.java.borowiec.dao.exception.UnexpectedExceptionDao;
import pl.java.borowiec.exception.UnExpectedException;
import pl.java.borowiec.service.exception.LoggerExceptionService;


/**
 * @author Sławomir Borowiec 
 * Module name : unExceptionPack
 * Creating time :  10-09-2012 15:55:37
 
 */
@Service
@Transactional(readOnly=true)
public class LoggerExceptionServiceImpl implements LoggerExceptionService{

	@SuppressWarnings("unused")
	private static Logger logger4J = LoggerFactory.getLogger(LoggerExceptionServiceImpl.class);
	@Autowired
	private UnexpectedExceptionDao unexpectedExceptionDao;
	

	@Override
	public List<UnExpectedException> getAllUnexpectedException() {
		return unexpectedExceptionDao.findAll();
	}
    @Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public UnExpectedException saveUnexpectedException(UnExpectedException unExpectedException) {
		return unexpectedExceptionDao.save(unExpectedException);
	}
	@Override
	public Page<UnExpectedException> findByException(String exception, Pageable pageable) {
		return unexpectedExceptionDao.findByException(exception, pageable);
	}
	
	@Override
	public Page<UnExpectedException> findByFunctionName(String functionName, Pageable pageable) {
		return unexpectedExceptionDao.findByFunctionName(functionName, pageable);
		
	}
	@Override
	public Page<UnExpectedException> getPageUnExpectedExcetpion(Pageable pageable) {
		return unexpectedExceptionDao.findAll(pageable);
	}
	@Override
	@Transactional
	public void persistException(UnExpectedException uee) {
	   unexpectedExceptionDao.save(uee);	
	}
	@Override
	@Transactional
	public void removeAll() {
		unexpectedExceptionDao.deleteAll();
		
	}
	@Override
	public void removeBy(String exception) {
	  throw new NotImplementedException();
	} 
	
}
