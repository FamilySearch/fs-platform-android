package org.familysearch.platform;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * A common representation of an error on the FamilySearch platform.
 *
 * @author Reed Ellsworth
 */
@Root (strict = false)
public class Error
{

  @Element (required = false)
  private Integer code;
  @Element (required = false)
  private String label;
  @Element (required = false)
  private String message;
  @Element (required = false)
  private String stacktrace;

  /**
   * The error code. Intepreted per <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html">RFC 2616, Section 10 (HTTP Status Code Definitions)</a>.
   *
   * @return The error code. Intepreted per <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html">RFC 2616, Section 10 (HTTP Status Code Definitions)</a>.
   */
  public Integer getCode() {
    return code;
  }

  /**
   * The error code. Intepreted per <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html">RFC 2616, Section 10 (HTTP Status Code Definitions)</a>.
   *
   * @param code The error code. Intepreted per <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html">RFC 2616, Section 10 (HTTP Status Code Definitions)</a>.
   */
  public void setCode( Integer code ) {
    this.code = code;
  }

  /**
   * A text label associated with the error code.
   *
   * @return A text label associated with the error code.
   */
  public String getLabel() {
    return label;
  }

  /**
   * A text label associated with the error code.
   *
   * @param label A text label associated with the error code.
   */
  public void setLabel( String label ) {
    this.label = label;
  }

  /**
   * A message associated with the error.
   *
   * @return A message associated with the error.
   */
  public String getMessage() {
    return message;
  }

  /**
   * A message associated with the error.
   *
   * @param message A message associated with the error.
   */
  public void setMessage( String message ) {
    this.message = message;
  }

  /**
   * The back-end stack trace associated with the error, useful for debugging.
   *
   * @return The back-end stack trace associated with the error, useful for debugging.
   */
  public String getStacktrace() {
    return stacktrace;
  }

  /**
   * The back-end stack trace associated with the error, useful for debugging.
   *
   * @param stacktrace The back-end stack trace associated with the error, useful for debugging.
   */
  public void setStacktrace( String stacktrace ) {
    this.stacktrace = stacktrace;
  }
}
