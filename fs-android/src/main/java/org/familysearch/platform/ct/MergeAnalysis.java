package org.familysearch.platform.ct;

import org.gedcomx.common.ResourceReference;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * @author Mike Gardiner
 */

@Root (strict = false)
@Order (elements = {"survivorResource", "duplicateResource", "conflictingResource", "survivor", "duplicate"})
public class MergeAnalysis
{
  @ElementList (entry = "survivorResource", inline = true, required = false)
  private List<ResourceReference> survivorResources;
  @ElementList (entry = "duplicateResource", inline = true, required = false)
  private List<ResourceReference> duplicateResources;
  @ElementList (entry = "conflictingResource", inline = true, required = false)
  private List<MergeConflict> conflictingResources;
  @Element (name = "survivor", required = false)
  private ResourceReference survivor;
  @Element (name = "duplicate", required = false)
  private ResourceReference duplicate;

  public List<ResourceReference> getSurvivorResources() {
    return survivorResources;
  }

  public void setSurvivorResources( List<ResourceReference> survivorResources ) {
    this.survivorResources = survivorResources;
  }

  public List<ResourceReference> getDuplicateResources() {
    return duplicateResources;
  }

  public void setDuplicateResources( List<ResourceReference> duplicateResources ) {
    this.duplicateResources = duplicateResources;
  }

  public List<MergeConflict> getConflictingResources() {
    return conflictingResources;
  }

  public void setConflictingResources( List<MergeConflict> conflictingResources ) {
    this.conflictingResources = conflictingResources;
  }


  public ResourceReference getSurvivor() {
    return survivor;
  }

  public void setSurvivor( ResourceReference survivor ) {
    this.survivor = survivor;
  }

  public ResourceReference getDuplicate() {
    return duplicate;
  }

  public void setDuplicate( ResourceReference duplicate ) {
    this.duplicate = duplicate;
  }


}
