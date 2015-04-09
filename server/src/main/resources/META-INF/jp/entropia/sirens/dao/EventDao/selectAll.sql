select
  event.id,
  event.name,
  event.place,
  event.logo_image,
  event.start_time,
  event.end_time,
  event.description,
  count(member.id) as member_count,
  max(case when member.userId = /* userId */'16cfc640-9ebd-493e-a2a2-56eca7db4834' then 1 else 0 end) as is_member,
  max(case when member.userId = /* userId */'16cfc640-9ebd-493e-a2a2-56eca7db4834' and manager.member_id is not NULL then 1 else 0 end) as is_manager
from event
  inner join member on event.id = member.event_id
  left outer join manager on member.id = manager.member_id
group by event.id