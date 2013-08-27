package org.familysearch.platform;

import org.familysearch.platform.ct.ChildAndParentsRelationship;
import org.familysearch.platform.ct.Merge;
import org.familysearch.platform.ct.MergeAnalysis;
import org.familysearch.platform.discussions.Discussion;
import org.familysearch.platform.users.User;
import org.gedcomx.Gedcomx;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>The FamilySearch media types define serialization formats that are specific the FamilySearch developer platform. These
 * media types are extensions of the <a href="http://gedcomx.org">GEDCOM X</a> media types and provide concepts and data types
 * that are specific to FamilySearch and therefore haven't been adopted into a formal, more general specification.</p>
 *
 * @author Reed Ellsworth
 */
@Root (name = "familysearch", strict = false)
@Order (elements = {"childAndParentsRelationship", "discussion", "user", "merge", "mergeAnalysis"})
public class FamilySearchPlatform extends Gedcomx
{

  public static final String XML_MEDIA_TYPE = FamilySearchConstants.FS_PLATFORM_V1_XML_MEDIA_TYPE;
  public static final String JSON_MEDIA_TYPE = FamilySearchConstants.FS_PLATFORM_V1_JSON_MEDIA_TYPE;

  @ElementList (entry = "mergeAnalysis", inline = true, required = false)
  private List<MergeAnalysis> mergeAnalyses;
  @ElementList (entry = "merge", inline = true, required = false)
  private List<Merge> merges;
  @ElementList (entry = "childAndParentsRelationship", inline = true, required = false)
  private List<ChildAndParentsRelationship> childAndParentsRelationships;
  @ElementList (entry = "discussion", inline = true, required = false)
  private List<Discussion> discussions;
  @ElementList (entry = "user", inline = true, required = false)
  private List<User> users;

  /**
   * The merge analysis results for this data set.
   *
   * @return The merge analysis results for this data set.
   */
  public List<MergeAnalysis> getMergeAnalyses() {
    return mergeAnalyses;
  }

  /**
   * The merge analysis results for this data set.
   *
   * @param mergeAnalyses The merge analysis results for this data set.
   */
  public void setMergeAnalyses( List<MergeAnalysis> mergeAnalyses ) {
    this.mergeAnalyses = mergeAnalyses;
  }

  /**
   * Add a MergeAnalysis to the data set.
   *
   * @param mergeAnalysis The MergeAnalysis to be added.
   */
  public void addMergeAnalysis( MergeAnalysis mergeAnalysis ) {
    if (mergeAnalysis != null) {
      if (mergeAnalyses == null) {
        mergeAnalyses = new LinkedList<MergeAnalysis>();
      }
      mergeAnalyses.add( mergeAnalysis );
    }
  }

  /**
   * The merges for this data set.
   *
   * @return The merges for this data set.
   */
  public List<Merge> getMerges() {
    return merges;
  }

  /**
   * The merges for this data set.
   *
   * @param merges The merges for this data set.
   */
  public void setMerges( List<Merge> merges ) {
    this.merges = merges;
  }

  /**
   * Add a merge to the data set.
   *
   * @param merge The merge to be added.
   */
  public void addMerge( Merge merge ) {
    if (merge != null) {
      if (merges == null) {
        merges = new LinkedList<Merge>();
      }
      merges.add( merge );
    }
  }

  /**
   * The child-and-parents relationships for this data set.
   *
   * @return The child-and-parents relationships for this data set.
   */
  public List<ChildAndParentsRelationship> getChildAndParentsRelationships() {
    return childAndParentsRelationships;
  }

  /**
   * The child-and-parents relationships for this data set.
   *
   * @param childAndParentsRelationships The child-and-parents relationships for this data set.
   */
  public void setChildAndParentsRelationships( List<ChildAndParentsRelationship> childAndParentsRelationships ) {
    this.childAndParentsRelationships = childAndParentsRelationships;
  }

  /**
   * Add a childAndParentsRelationship to the data set.
   *
   * @param childAndParentsRelationship The childAndParentsRelationship to be added.
   */
  public void addChildandparentsrelationship( ChildAndParentsRelationship childAndParentsRelationship ) {
    if (childAndParentsRelationship != null) {
      if (childAndParentsRelationships == null) {
        childAndParentsRelationships = new LinkedList<ChildAndParentsRelationship>();
      }
      childAndParentsRelationships.add( childAndParentsRelationship );
    }
  }

  /**
   * The discussions included in this data set.
   *
   * @return The discussions included in this data set.
   */
  public List<Discussion> getDiscussions() {
    return discussions;
  }

  /**
   * The discussions included in this data set.
   *
   * @param discussions The discussions included in this data set.
   */
  public void setDiscussions( List<Discussion> discussions ) {
    this.discussions = discussions;
  }

  /**
   * Add a discussion to the data set.
   *
   * @param discussion The discussion to be added.
   */
  public void addDiscussion( Discussion discussion ) {
    if (discussion != null) {
      if (discussions == null) {
        discussions = new LinkedList<Discussion>();
      }
      discussions.add( discussion );
    }
  }

  /**
   * The users included in this data set.
   *
   * @return The users included in this genealogical data set.
   */
  public List<User> getUsers() {
    return users;
  }

  /**
   * The users included in this data set.
   *
   * @param users The users included in this data set.
   */
  public void setUsers( List<User> users ) {
    this.users = users;
  }

  /**
   * Add a user to the data set.
   *
   * @param user The user to be added.
   */
  public void addUser( User user ) {
    if (user != null) {
      if (users == null) {
        users = new LinkedList<User>();
      }
      users.add( user );
    }
  }


}
