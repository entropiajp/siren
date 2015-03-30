select
  case count(*)
    when 1 then true
    else 0
  end as admin
from manager
  inner join member on manager.member_id = member.id
  where
    member.userId = /* userId */'f5d5beae-e513-4d31-bb52-386a389e2fd3' and
    manager.event_id = /* eventId */1