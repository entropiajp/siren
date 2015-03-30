select * from event
  where event.id in (
    select member.event_id from member
      where member.userId = /* userId */'f5d5beae-e513-4d31-bb52-386a389e2fd3')