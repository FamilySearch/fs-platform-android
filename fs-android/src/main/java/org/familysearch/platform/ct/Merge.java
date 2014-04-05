package org.familysearch.platform.ct;

import org.gedcomx.common.ResourceReference;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * @author Mike Gardiner
 */

@Root (strict = false)
@Order (elements = {"resourceToDelete", "resourceToCopy"})
public class Merge
{
  @ElementList (entry = "resourceToDelete", inline = true, required = false)
  private List<ResourceReference> resourcesToDelete;
  @ElementList (entry = "resourceToCopy", inline = true, required = false)
  private List<ResourceReference> resourcesToCopy;

  /**
   * @return List of resources to remove from the survivor person.
   */
  public List<ResourceReference> getResourcesToDelete() {
    return resourcesToDelete;
  }

  public void setResourcesToDelete( List<ResourceReference> resourcesToDelete ) {
    this.resourcesToDelete = resourcesToDelete;
  }

  /**
   * @return List of resources to copy from the duplicate person to survivor person.
   */
  public List<ResourceReference> getResourcesToCopy() {
    return resourcesToCopy;
  }

  public void setResourcesToCopy( List<ResourceReference> resourcesToCopy ) {
    this.resourcesToCopy = resourcesToCopy;
  }


}
