select
  event.id as eventId,
  event.name as eventName,
  tune.id as tuneId,
  tune.name as tuneName,
  role.id as roleId,
  role.name as roleName
from role
  inner join song on role.song_id = song.id
  inner join member on role.member_id = member.id
  inner join event on song.event_id = event.id
  inner join tune on song.tune_id = tune.id
where
  member.userId = /* userId */'7ee442cd-3c4d-454e-84f3-5da722540345' and
  event.id = /* eventId */1