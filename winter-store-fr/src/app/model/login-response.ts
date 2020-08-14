import {UserDetailed} from './user-detailed';

export interface LoginResponse {
  token: string;
  userDetailed: UserDetailed;
}
