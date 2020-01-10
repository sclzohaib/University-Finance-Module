import { GstService } from './../../../../../core/services/Purchase/gst.service';
import { Component, OnInit, Input } from '@angular/core';
import { Gst } from 'src/app/core/models/Purchase/gst';
import { NzModalRef, NzMessageService } from 'ng-zorro-antd';
import { AuthLvlAddModalComponent } from '../../../authorize-lvl/components/auth-lvl-add-modal/auth-lvl-add-modal.component';

@Component({
  selector: 'app-gst-edit-modal',
  templateUrl: './gst-edit-modal.component.html',
  styleUrls: ['./gst-edit-modal.component.less']
})
export class GstEditModalComponent implements OnInit {

	@Input() gstt: Gst;
  constructor(private gstService: GstService,
		private modalRef: NzModalRef<AuthLvlAddModalComponent>,
		private message: NzMessageService) { }

  ngOnInit() {
	}

	onCancel() {
		this.modalRef.triggerCancel();
	}

	updateGst(){
		this.gstService.updateGst(this.gstt.id, this.gstt).subscribe(
			data => {
				this.message.create('success', `GST Updated Successfully!`,{nzDuration:3000});
				// console.log(JSON.parse(JSON.stringify(this.authLvl)))
				this.modalRef.triggerOk();
			},
			error => {
				this.message.create('error', `GST Not Updated!`,{nzDuration:3000});
			}
		);

		// this.modalRef.close();
	}

}
