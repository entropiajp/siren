select 
  UserProfile.name,
  UserConnection.imageUrl
from users
  inner join UserProfile on users.username = UserProfile.userId
  inner join UserConnection on users.username = UserConnection.userId
  where users.username = /* userId */'f5d5beae-e513-4d31-bb52-386a389e2fd3'