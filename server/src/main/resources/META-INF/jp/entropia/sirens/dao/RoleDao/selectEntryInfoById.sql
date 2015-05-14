select
  event.name as eventName,
  tune.name as tuneName,
  role.name as roleName
from role
  inner join song on role.song_id = song.id
  inner join event on song.event_id = event.id
  inner join tune on song.tune_id = tune.id
where
  role.id = /* id */22