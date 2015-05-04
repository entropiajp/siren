delete member_part
from member_part
  inner join member on member_part.member_id = member.id
where
  event_id = /* eventId */1