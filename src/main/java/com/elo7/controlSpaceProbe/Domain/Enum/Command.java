package com.elo7.controlSpaceProbe.Domain.Enum;

public enum Command {
    L('L'),
    M('M'),
    R('R');

    Command(char command) {
    }

    public int commandM(int pos){
        return pos+1;
    }

    public Direction commandL(Direction d){
        Direction direction = d;
        if(d.ordinal() == 0){
            direction = Direction.W;
        } else {
            int pos = d.ordinal() - 1;
            direction = direction.getDirectionByOrder(pos);
        }
        return direction;
    }

    public Direction commandR(Direction d){
        Direction direction = d;
        if(d.ordinal() == 3){
            direction = Direction.N;
        } else {
            int pos = d.ordinal() + 1;
            direction = direction.getDirectionByOrder(pos);
        }
        return direction;
    }

}
