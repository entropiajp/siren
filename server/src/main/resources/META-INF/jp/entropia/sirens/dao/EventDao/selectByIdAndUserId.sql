select
  event.id,
  event.name,
  event.place,
  event.image_url,
  event.start_time,
  event.end_time,
  event.description,
  event.vote_start_time,
  event.vote_end_time,
  event.vote_limit,
  event.vote_message,
  event.join_start_time,
  event.join_end_time,
  event.join_limit,
  event.join_message,
  count(member.id) as member_count,
  max(case when member.userId = /* userId */'16cfc640-9ebd-493e-a2a2-56eca7db4834' then 1 else 0 end) as is_member,
  max(case when member.userId = /* userId */'16cfc640-9ebd-493e-a2a2-56eca7db4834' and manager.member_id is not NULL then 1 else 0 end) as is_manager
from event
  inner join member on event.id = member.event_id
  left outer join manager on member.id = manager.member_id
where event.id = /* id */1
group by event.id