select
  vote.tune_id,
  tune.name,
  count(member_id) as count
from vote
  inner join tune on vote.tune_id = tune.id
  inner join member on vote.member_id = member.id
where
  member.event_id = /* eventId */1
group by
  tune_id
order by
  count desc