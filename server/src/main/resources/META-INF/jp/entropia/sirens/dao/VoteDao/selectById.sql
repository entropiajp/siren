select
  /*%expand*/*
from
  vote
where
  member_id = /* memberId */1
  and
  tune_id = /* tuneId */1
