select * from event
  where event.id in (
    select manager.event_id from manager
      inner join member on manager.`member_id` = member.id
      where member.userId = /* userId */'f5d5beae-e513-4d31-bb52-386a389e2fd3')