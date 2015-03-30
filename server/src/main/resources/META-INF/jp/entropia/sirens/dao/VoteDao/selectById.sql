select
  /*%expand*/*
from
  vote
where
  member_id = /* memberId */1
  and
  candidate_id = /* candidateId */1
