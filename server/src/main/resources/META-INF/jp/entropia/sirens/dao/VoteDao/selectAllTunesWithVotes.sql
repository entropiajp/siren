select
  tune.id,
  tune.track_no,
  tune.name,
  tune.time,
  tune.artist,
  tune.source,
  case
    when vote.member_id is null then false
    else true
  end as is_voted
from tune
  left outer join
  (select * from vote where vote.member_id = /* memberId */1) as vote on tune.id = vote.tune_id
order by is_voted desc, tune.id