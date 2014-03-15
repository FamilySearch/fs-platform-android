package org.familysearch.platform.ct;

import org.gedcomx.common.ResourceReference;
import org.gedcomx.conclusion.Fact;
import org.gedcomx.conclusion.Subject;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;


/**
 * The FamilySearch-proprietary model for a relationship between a child and a pair of parents.
 */
@Root (strict = false)
@Order (elements = {"father", "mother", "child", "fatherFact", "motherFact"})
public class ChildAndParentsRelationship extends Subject
{
  @Element (required = false)
  private ResourceReference father;
  @Element (required = false)
  private ResourceReference mother;
  @Element (required = false)
  private ResourceReference child;
  @ElementList (entry = "fatherFact", inline = true, required = false)
  private List<Fact> fatherFacts;
  @ElementList (entry = "motherFact", inline = true, required = false)
  private List<Fact> motherFacts;

  /**
   * The father of the child.
   *
   * @return The father of the child.
   */
  public ResourceReference getFather() {
    return father;
  }

  /**
   * Set the father of the child.
   *
   * @param father The father of the child.
   */
  public void setFather( ResourceReference father ) {
    this.father = father;
  }

  /**
   * The mother of the child.
   *
   * @return The mother of the child.
   */
  public ResourceReference getMother() {
    return mother;
  }

  /**
   * Set the mother of the child.
   *
   * @param mother The mother of the child.
   */
  public void setMother( ResourceReference mother ) {
    this.mother = mother;
  }

  /**
   * The child in the relationship.
   *
   * @return child in the relationship.
   */
  public ResourceReference getChild() {
    return child;
  }

  /**
   * Set the child in the relationship.
   *
   * @param child child in the relationship.
   */
  public void setChild( ResourceReference child ) {
    this.child = child;
  }

  /**
   * The fact conclusions for the father.
   *
   * @return The fact conclusions for the father.
   */
  public List<Fact> getFatherFacts() {
    return fatherFacts;
  }

  /**
   * The fact conclusions for the father.
   *
   * @param facts The fact conclusions for the father.
   */
  public void setFatherFacts( List<Fact> facts ) {
    this.fatherFacts = facts;
  }

  /**
   * Add a fact conclusion for the father.
   *
   * @param fact The fact conclusion to be added.
   */
  public void addFatherFact( Fact fact ) {
    if (fact != null) {
      if (fatherFacts == null) {
        fatherFacts = new ArrayList<Fact>();
      }
      fatherFacts.add( fact );
    }
  }

  /**
   * The fact conclusions for the mother.
   *
   * @return The fact conclusions for the mother.
   */
  public List<Fact> getMotherFacts() {
    return motherFacts;
  }

  /**
   * The fact conclusions for the mother.
   *
   * @param facts The fact conclusions for the mother.
   */
  public void setMotherFacts( List<Fact> facts ) {
    this.motherFacts = facts;
  }

  /**
   * Add a fact conclusion for the mother.
   *
   * @param fact The fact conclusion to be added.
   */
  public void addMotherFact( Fact fact ) {
    if (fact != null) {
      if (motherFacts == null) {
        motherFacts = new ArrayList<Fact>();
      }
      motherFacts.add( fact );
    }
  }


}
