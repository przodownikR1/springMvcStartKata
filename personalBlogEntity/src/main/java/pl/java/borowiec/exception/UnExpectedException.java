package pl.java.borowiec.exception;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogEntity
 *         Creating time : 11-04-2013 00:01:17
 */
@Entity
@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UnExpectedException extends ExceptionHandling {
    public UnExpectedException(String string, String msg, String description, String moduleName, String logPrefix, String formOrModuleName2) {
        setErrorNumber(string);
        setException(msg);
        setDescription(description);
        setFunctionName(moduleName);
        setMessage(logPrefix);
        setFormOrModuleName(formOrModuleName2);
    }

    private static final long serialVersionUID = 8284569238600218725L;
    protected static final String TABLE_NAME = "UNEXPECTED_EXCEPTION";

    @NotNull
    @Column(name = "error_number", nullable = false, length = 128)
    private String errorNumber;

    @NotNull
    @Column(name = "function_name", nullable = false, length = 128)
    private String functionName;

    @NotNull
    @Column(name = "module_name", nullable = false, length = 128)
    private String formOrModuleName;

    @Column(name = "arguments", length = 256)
    private String arguments;

}
