package org.familysearch.platform.ct;

/**
 * @author Mike Gardiner
 */
public enum PersonMergeConstraint
{
  CAN_MERGE_ANY_ORDER,
  CAN_MERGE_OTHER_ORDER_ONLY,
  CAN_MERGE_THIS_ORDER_ONLY,
  CANNOT_MERGE_ANY_ORDER_CP_CONSTRAINT,
  CANNOT_MERGE_ANY_ORDER_CP_CONSTRAINT_ALREADY_MERGED,
  CANNOT_MERGE_ANY_ORDER_CP_CONSTRAINT_AT_LEASE_TWO_UNIQUE_MERGE_CANDIDATES_REQUIRED,
  CANNOT_MERGE_ANY_ORDER_CP_CONSTRAINT_MISMATCHED_GENDERS,
  CANNOT_MERGE_ANY_ORDER_CP_CONSTRAINT_NO_EDIT_RIGHTS,
  CANNOT_MERGE_ANY_ORDER_CP_CONSTRAINT_CONTRIBUTOR_CANNOT_WRITE_TO_START_PERSON,
  CANNOT_MERGE_ANY_ORDER_CP_CONSTRAINT_CONTRIBUTOR_CANNOT_WRITE_TO_CANDIDATE_PERSON,
  CANNOT_MERGE_ANY_ORDER_CP_CONSTRAINT_CONTRIBUTOR_CANNOT_WRITE_TO_PERSON,
  CANNOT_MERGE_ANY_ORDER_CP_CONSTRAINT_CMIS_CANT_MERGE_NONCMIS_PERSONS,
  CANNOT_MERGE_ANY_ORDER_CP_CONSTRAINT_MULTIPLE_CMIS,
  CANNOT_MERGE_ANY_ORDER_CP_CONSTRAINT_MULTIPLE_CMIS_OR_USERS,
  CANNOT_MERGE_ANY_ORDER_CP_CONSTRAINT_MULTIPLE_CMIS_OR_CONTROLLED,
  CANNOT_MERGE_ANY_ORDER_CP_CONSTRAINT_NO_CMIS_EDIT_RIGHTS,
  CANNOT_MERGE_ANY_ORDER_CP_CONSTRAINT_START_PERSON_HAS_NO_CMIS_EDIT_RIGHTS,
  CANNOT_MERGE_ANY_ORDER_CP_CONSTRAINT_MERGING_WOULD_HIDE_STUFF,
  CANNOT_MERGE_ANY_ORDER_CP_CONSTRAINT_MERGING_WOULD_HIDE_STUFF_ON_CMIS_RECORDS,
  CANNOT_MERGE_ANY_ORDER_CP_CONSTRAINT_MERGING_WOULD_CAUSE_LOOP,
  CANNOT_MERGE_ANY_ORDER_CP_CONSTRAINT_PRIMARY_MERGE_CANDIDATE_CANNOT_BE_MERGED,
  CANNOT_MERGE_ANY_ORDER_CP_CONSTRAINT_ALL_OTHER_MERGE_CANDIDATES_CANNOT_BE_MERGED,
  CANNOT_MERGE_ANY_ORDER_CP_CONSTRAINT_TOO_MANY_INNER_PERSONS,
  CANNOT_MERGE_ANY_ORDER_CP_CONSTRAINT_MERGE_START_PERSON_NOT_FOUND,
  CANNOT_MERGE_ANY_ORDER_CP_CONSTRAINT_MERGE_CANDIDATE_NOT_FOUND,
  CANNOT_MERGE_ANY_ORDER_GENDER_MISMATCH,
  CANNOT_MERGE_ANY_ORDER_LIVING_CONTRIBUTOR_MISMATCH,
  CANNOT_MERGE_ANY_ORDER_LIVING_STATUS_MISMATCH,
  CANNOT_MERGE_ANY_ORDER_PARENT_AND_CHILD,
  CANNOT_MERGE_ANY_ORDER_NON_UNIQUE_IDS,
  CANNOT_MERGE_ANY_ORDER_TOMBSTONED_PERSON,
  CANNOT_MERGE_ANY_ORDER_FORWARDED_PERSON,
  CANNOT_MERGE_ANY_ORDER_PERSON_NOT_FOUND,
  CANNOT_MERGE_ANY_ORDER_LOCKED_PERSON,
  CANNOT_MERGE_ANY_ORDER_LOCKED_RELATIONSHIP,
  CANNOT_MERGE_ANY_ORDER_DIFFERENT_SPACES,
}