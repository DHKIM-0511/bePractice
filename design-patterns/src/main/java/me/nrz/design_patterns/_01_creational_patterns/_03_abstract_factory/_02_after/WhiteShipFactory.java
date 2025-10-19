package me.nrz.design_patterns._01_creational_patterns._03_abstract_factory._02_after;

import me.nrz.design_patterns._01_creational_patterns._02_factory_method._02_after.DefaultShipFactory;
import me.nrz.design_patterns._01_creational_patterns._02_factory_method._02_after.Ship;
import me.nrz.design_patterns._01_creational_patterns._02_factory_method._02_after.Whiteship;

/**
 * 클라이언트 코드
 *
 */
public class WhiteShipFactory extends DefaultShipFactory {

    private ShipPartsFactory shipPartsFactory;

    public WhiteShipFactory(ShipPartsFactory shipPartsFactory) {
        this.shipPartsFactory = shipPartsFactory;
    }

    @Override
    public Ship createShip() {
        Ship ship = new Whiteship();
        ship.setAnchor(shipPartsFactory.createAnchor());
        ship.setWheel(shipPartsFactory.createWheel());
        return ship;
    }
}
