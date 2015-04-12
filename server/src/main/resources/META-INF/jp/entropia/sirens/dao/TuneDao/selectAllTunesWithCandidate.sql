select
  tune.id,
  tune.track_no,
  tune.name,
  tune.time,
  tune.artist,
  tune.source,
  case
    when candidate.id is null then false
    else true
  end as is_candidate
from tune
  left outer join
  (select * from song where song.event_id = /* eventId */3) as candidate on tune.id = candidate.tune_id
order by is_candidate desc, tune.id