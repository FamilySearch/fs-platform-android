package org.familysearch.platform.ct;

import org.gedcomx.common.ResourceReference;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

/**
 * @author Mike Gardiner
 */
@Root (strict = false)
@Order (elements = {"survivorResource", "duplicateResource"})
public class MergeConflict
{
  @Element (name = "survivorResource", required = false)
  private ResourceReference survivorResource;
  @Element (name = "duplicateResource", required = false)
  private ResourceReference duplicateResource;

  public MergeConflict() {

  }

  public MergeConflict( ResourceReference survivorResource, ResourceReference duplicateResource ) {
    this.survivorResource = survivorResource;
    this.duplicateResource = duplicateResource;
  }

  public ResourceReference getSurvivorResource() {
    return survivorResource;
  }

  public void setSurvivorResource( ResourceReference survivorResource ) {
    this.survivorResource = survivorResource;
  }

  public ResourceReference getDuplicateResource() {
    return duplicateResource;
  }

  public void setDuplicateResource( ResourceReference duplicateResource ) {
    this.duplicateResource = duplicateResource;
  }
}
