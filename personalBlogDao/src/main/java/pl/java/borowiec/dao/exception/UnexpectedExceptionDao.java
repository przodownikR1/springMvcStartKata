
package pl.java.borowiec.dao.exception;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.java.borowiec.exception.UnExpectedException;



/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogDao
 * Creating time :  11-04-2013 00:06:29
 
 */
public interface UnexpectedExceptionDao extends JpaRepository<UnExpectedException, Long>, JpaSpecificationExecutor<UnExpectedException> {
	
    Page<UnExpectedException> findByException(String exception, Pageable pageable);
		
	Page<UnExpectedException> findByFunctionName(String functionName, Pageable pageable);
	
}
