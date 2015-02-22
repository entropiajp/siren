select
  /*%expand*/*
from
  UserConnection
where
  userId = /* userid */'a'
  and
  providerId = /* providerid */'a'
  and
  providerUserId = /* provideruserid */'a'
