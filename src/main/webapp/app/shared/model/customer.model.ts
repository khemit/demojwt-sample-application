import { IWishList } from 'app/shared/model/wish-list.model';
import { IAddress } from 'app/shared/model/address.model';
import { NotificationType } from 'app/shared/model/enumerations/notification-type.model';

export interface ICustomer {
  id?: number;
  firstName?: string;
  lastName?: string;
  email?: string;
  telephone?: string;
  channel?: NotificationType;
  wishLists?: IWishList[];
  addresses?: IAddress[];
}

export const defaultValue: Readonly<ICustomer> = {};
