delete vote
from vote
  inner join member on vote.member_id = member.id
where
  event_id = /* eventId */1