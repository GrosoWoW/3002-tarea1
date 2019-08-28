package model.items.attack.normal;

import model.items.IEquipableItem;

interface IAttack extends IEquipableItem {

    double attack(IEquipableItem item);
}
